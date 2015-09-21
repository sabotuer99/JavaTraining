%DERBY_HOME%\bin\startNetworkServer.bat

%DERBY_HOME%\bin\ij.bat 

connect 'jdbc:derby://localhost:1527/java;create=true';

run 'c:\jmed\admin\populateDatabase.sql';