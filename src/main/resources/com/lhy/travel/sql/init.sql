create database League;
use League;

/*俱乐部信息*/
create table 俱乐部信息 (
                       俱乐部序号			varchar(10)	not null unique,
                       俱乐部名			varchar(20)	not null,
                       联赛				varchar(20)	not null,
                       主席				varchar(20)	not null,
                       主教练姓名			varchar(20)	not null,
                       已赛				int,
                       积分				int,
                       胜场				int,
                       负场				int,
                       平场				int,
                       进球数			int,
                       失球数			int,
                       净胜球			int,
                       排名				int,
                       primary key (俱乐部序号)
) character set = utf8mb4;

/*俱乐部主场*/
create table 俱乐部主场 (
                       球场号				varchar(10) not null unique,
                       球场名				varchar(20) not null,
                       城市				varchar(20) not null,
                       容量				int,
                       俱乐部序号			varchar(10) not null unique,
                       俱乐部名			varchar(20) not null unique,
                       primary key (球场号),
                       foreign key (俱乐部序号) references 俱乐部信息(俱乐部序号)
) character set = utf8mb4;

/*球员信息*/
create table 球员信息	(
                         球员序号			varchar(10)	not null unique,
                         球员姓名			varchar(20)	not null,
                         球员号码			varchar(5)	not null,
                         球员国籍			varchar(20)	not null,
                         球员年龄			varchar(5)	not null,
                         身高				int,
                         体重				int,
                         身价				int,
                         俱乐部序号			varchar(10)	not null unique,
                         俱乐部名			varchar(20)	not null,
                         场上位置			varchar(20)	not null,
                         上场次数			int,
                         替补上场次数		int,
                         球员总进球数		int,
                         球员总助攻数		int,
                         总红牌数			int,
                         总黄牌数			int,
                         primary key (球员序号),
                         foreign key (俱乐部序号) references 俱乐部信息(俱乐部序号)
) character set = utf8mb4;

/*主教练信息*/
create table 主教练信息 (
                       主教练序号			varchar(5)	not null unique,
                       主教练姓名			varchar(20)	not null,
                       主教练国籍			varchar(20)	not null,
                       主教练年龄			int,
                       俱乐部序号			varchar(20)	not null,
                       俱乐部名			varchar(20)	not null,
                       primary key (主教练序号),
                       foreign key (俱乐部序号) references 俱乐部信息(俱乐部序号)
) character set = utf8mb4;

/*裁判信息*/
create table 主裁判信息 (
                       主裁判号			varchar(20) not null unique,
                       主裁判姓名			varchar(20)	not null,
                       主裁判国籍			varchar(20)	not null,
                       主裁判年龄			int,
                       primary key (主裁判号)
) character set = utf8mb4;

/*比赛信息*/
create table 比赛信息 (
                      比赛号				varchar(10)	not null unique,
                      时间				varchar(30)	not null unique,
                      轮次				int not null unique,
                      主场名				varchar(20)	not null unique,
                      主队序号			varchar(20)	not null unique,
                      主队名				varchar(20)	not null unique,
                      客队序号			varchar(20) not null unique,
                      客队名				varchar(20)	not null unique,
                      主裁判号			varchar(20) not null unique,
                      主裁判姓名			varchar(20) not null unique,
                      主队进球数			int	not null unique,
                      客队进球数			int	not null unique,
                      primary key (比赛号),
                      foreign key (主队序号) references 俱乐部信息(俱乐部序号),
                      foreign key (客队序号) references 俱乐部信息(俱乐部序号),
                      foreign key (主裁判号) references 主裁判信息(主裁判号)
) character set = utf8mb4;

/*球员踢比赛信息*/
create table 球员踢比赛 (
                       球员序号			varchar(20) not null unique,
                       球员姓名			varchar(20) not null unique,
                       比赛号				varchar(20)	not null unique,
                       轮次				int not null unique,
                       主队名				varchar(20) not null unique,
                       客队名				varchar(20) not null unique,
                       上场时间			int unique,
                       是否为替补			varchar(5)	not null unique,
                       进球数				int unique,
                       助攻数				int unique,
                       黄牌数				int unique,
                       红牌数				int unique,
                       primary key (球员序号),
                       foreign key (球员序号) references 球员信息(球员序号),
                       foreign key (比赛号) references 比赛信息(比赛号)
) character set = utf8mb4;

/*主裁判执法比赛*/
create table 执法比赛 (
                      比赛号				varchar(10) not null unique,
                      主裁判号			varchar(20) not null unique,
                      主裁判姓名			varchar(20)	not null,
                      时间				varchar(30)	not null unique,
                      轮次				int not null unique,
                      主队名				varchar(20)	not null unique,
                      客队名				varchar(20)	not null unique,
                      球场号				varchar(10) not null unique,
                      球场名				varchar(20) not null,
                      primary key (比赛号),
                      foreign key (比赛号) references 比赛信息(比赛号),
                      foreign key (主裁判号) references 主裁判信息(主裁判号),
                      foreign key (球场号) references 俱乐部主场(球场号)
)character set = utf8mb4;

/*球员合同*/
create table 球员合同 (
                      球员序号			varchar(20)	not null unique,
                      球员姓名			varchar(20) not null,
                      俱乐部序号			varchar(20) not null unique,
                      俱乐部名			varchar(20) not null,
                      周薪				varchar(20) not null,
                      合同开始			varchar(20)	not null,
                      合同结束			varchar(20)	not null,
                      primary key (球员序号),
                      foreign key (球员序号) references 球员信息(球员序号),
                      foreign key (俱乐部序号) references 俱乐部信息(俱乐部序号)
) character set = utf8mb4;

/*主教练合同*/
create table 主教练合同 (
                       主教练序号			varchar(20)	not null unique,
                       主教练姓名			varchar(20)	not null,
                       俱乐部序号			varchar(20) not null unique,
                       俱乐部名			varchar(20) not null,
                       周薪				varchar(20)	not null,
                       合同开始			varchar(20)	not null,
                       合同结束			varchar(20)	not null,
                       primary key (主教练序号),
                       foreign key (主教练序号) references 主教练信息(主教练序号),
                       foreign key (俱乐部序号) references 俱乐部信息(俱乐部序号)
) character set = utf8mb4;