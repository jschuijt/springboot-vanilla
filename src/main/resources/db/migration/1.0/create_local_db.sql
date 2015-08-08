/*
* Create an Oracle database locally
*/

create tablespace demo_tbs datafile 'demo_tbs.dat' size 10M reuse autoextend on next 10M maxsize 200M;

drop user demo cascade;
create user demo identified by demo default tablespace demo_tbs;
grant
 create session,
 create any table,
 alter any table,
 drop any table,
 create any sequence,
 alter any sequence,
 drop any sequence
 create any index,
 alter any index,
 drop any sequence,
 create any view,
 alter any view,
 drop any view,
 create any trigger,
 alter any trigger,
 drop any trigger,
 create any procedure,
 alter any procedure,
 drop any procedure,
 analyze any
 to demo;
 
 grant unlimited tablespace to demo;