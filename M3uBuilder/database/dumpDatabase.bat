@echo off
title M3uBuilder DB Dumper
color 03
set user=eclipse
set host=localhost
set port=3306
set dbName=filesystem
set dumpCreate=V1__Create_filesystem_db.sql
set dumpInsert=V2__Add_test_values.sql
SetLocal EnableDelayedExpansion
set n=^



set ignoreTables=schema_version
echo Database Dumper 
echo.
echo Ignoring following table/s:  -------------------------------------------------
echo.
for /f "tokens=*" %%a in ("!ignoreTables!") do (
	echo %dbName%.%%a
	set ignoreCommand=!ignoreCommand! --ignore-table=%dbName%.%%a
)
echo.
echo Creating database and table dump ---------------------------------------------
echo.
mysqldump --verbose --user=%user% --host=%host% --port=%port% --disable-keys --single-transaction --add-drop-database --add-locks --no-data!ignoreCommand! --databases %dbName% > %dumpCreate% || goto error
echo.
echo Creating insert data dump ----------------------------------------------------
echo.
mysqldump --verbose --user=%user% --host=%host% --port=%port%  --disable-keys --single-transaction --skip-extended-insert --quick --add-locks --no-create-db --no-create-info!ignoreCommand! --databases %dbName% > %dumpInsert% || goto error
echo.
echo ------------------------------------------------------------------------------
goto end
:error
echo couldn't start mysqldump, 
echo please check if you have set the path variable
echo.
echo you can set it with:
echo setx path "%%path%%";^<Path_to_mysqldump.exe^>
:end
EndLocal
pause