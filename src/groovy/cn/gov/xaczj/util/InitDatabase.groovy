package cn.gov.xaczj.util

import test.*
import java.util.Calendar
import cn.gov.xaczj.*;
class InitDatabase {

	
	public static lunch()
	{
		
		def init_role=new Role();
		init_role.name="西安市财政局"
		init_role.save()
		
		init_role=new Role();
		init_role.name="西安市本级"
		init_role.save()
		
		init_role=new Role();
		init_role.name="区县/开发区财政局"
		init_role.save()
		
		init_role=new Role();
		init_role.name="建设单位"
		init_role.save()
		//role表建完
		def init_acount=new Acount()
		init_acount=new Acount()
		init_acount.acountName="admin"
		init_acount.password="admin"
		init_acount.save()
		//权限账号
		init_acount=new Acount()
		init_acount.acountName="xassbj"
		init_acount.password="123"
		init_acount.save()
		//西安市市本级
		init_acount=new Acount()
		init_acount.acountName="xasczj"
		init_acount.password="123"
		init_acount.save()
		//西安市财政局
		
		init_acount=new Acount()
		init_acount.acountName="blqczj"
		init_acount.password="123"
		init_acount.save()
		/*4 qx 1 碑林区*/
		init_acount=new Acount()
		init_acount.acountName="wyqczj"
		init_acount.password="123"
		init_acount.save()
		/*5 qx 2未央*/
		init_acount=new Acount()
		init_acount.acountName="lhqczj"
		init_acount.password="123"
		init_acount.save()
		/*6 qx 3莲湖*/
		init_acount=new Acount()
		init_acount.acountName="ytqczj"
		init_acount.password="123"
		init_acount.save()
		/*7 qx 4 雁塔*/
		init_acount=new Acount()
		init_acount.acountName="xcqczj"
		init_acount.password="123"
		init_acount.save()
		/*8 qx 5新城*/
		init_acount=new Acount()
		init_acount.acountName="bqqsczj"
		init_acount.password="123"
		init_acount.save()
		/*9 qx 6灞桥*/
		init_acount=new Acount()
		init_acount.acountName="caqczj"
		init_acount.password="123"
		init_acount.save()
		/*10 qx 7长安*/
		init_acount=new Acount()
		init_acount.acountName="ltqczj"
		init_acount.password="123"
		init_acount.save()
		/*11 qx 8临潼*/
		init_acount=new Acount()
		init_acount.acountName="ylqczj"
		init_acount.password="123"
		init_acount.save()
		/*12 qx 9阎良*/
		init_acount=new Acount()
		init_acount.acountName="hxqczj"
		init_acount.password="123"
		init_acount.save()
		/*13 qx 10户县*/
		init_acount=new Acount()
		init_acount.acountName="ltxqczj"
		init_acount.password="123"
		init_acount.save()
		/*14 qx 11蓝田*/
		init_acount=new Acount()
		init_acount.acountName="zzxqczj"
		init_acount.password="123"
		init_acount.save()
		/*15 qx 12周至*/
		init_acount=new Acount()
		init_acount.acountName="glxqczj"
		init_acount.password="123"
		init_acount.save()
		/*16 qx 13高陵*/
		init_acount=new Acount()
		init_acount.acountName="jkkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*17 qx 15经开*/
		init_acount=new Acount()
		init_acount.acountName="gxkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*18 qx 15高新*/
		init_acount=new Acount()
		init_acount.acountName="qjkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*19 qx 16曲江*/
		init_acount=new Acount()
		init_acount.acountName="htjdkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*20 qx 17航天基地*/
		init_acount=new Acount()
		init_acount.acountName="hkjdkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*21 qx 18 航空基地*/
		init_acount=new Acount()
		init_acount.acountName="cbkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*22 qx 19浐灞*/
		init_acount=new Acount()
		init_acount.acountName="fdxqkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*23 qx 20沣东新区*/
		init_acount=new Acount()
		init_acount.acountName="gjgwkfqczj"
		init_acount.password="123"
		init_acount.save()
		/*24 qx 21 国际港务*/

		init_acount=new Acount()
		init_acount.acountName="xassbjjsdwA"
		init_acount.password="123"
		init_acount.save()
		/*25*/
		
		init_acount=new Acount()
		init_acount.acountName="xassbjjsdwB"
		init_acount.password="123"
		init_acount.save()
		/*26*/
		init_acount=new Acount()
		init_acount.acountName="blqjsdwA"
		init_acount.password="123"
		init_acount.save()
		/*27*/
		init_acount=new Acount()
		init_acount.acountName="blqjsdwB"
		init_acount.password="123"
		init_acount.save()
		/*28*/
		init_acount=new Acount()
		init_acount.acountName="ytqjsdwA"
		init_acount.password="123"
		init_acount.save()
		/*29*/
		init_acount=new Acount()
		init_acount.acountName="ytqjsdwB"
		init_acount.password="123"
		init_acount.save()
		/*30*/
		//acount表建完
		def a
		def b
		def init_post=new Post()
		init_post.no=0
		a=Role.get(1)
		init_post.setRole(a)
		init_post.parentPost=0
		init_post.postName="西安市财政局审核员"
		init_post.unit="xasczj"
		init_post.operater="shy"
		b=Acount.get(3)
		init_post.setAcount(b)
		init_post.save()

		init_post=new Post()
		init_post.no=1
		a=Role.get(2)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="西安市市本级审核员"
		init_post.unit="xassbj"
		init_post.operater="shy"
		b=Acount.get(2)
		init_post.setAcount(b)
		init_post.save()
		
		
		init_post=new Post()
		init_post.no=2
		a=Role.get(2)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="西安市市本级综合处"
		init_post.unit="xassbj"
		init_post.operater="tby"
		b=Acount.get(2)
		init_post.setAcount(b)
		init_post.save()
		init_post.save()

		init_post=new Post()
		init_post.no=3
		a=Role.get(2)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="西安市市本级经建处"
		init_post.unit="xassbj"
		init_post.operater="tby"
		b=Acount.get(2)
		init_post.setAcount(b)
		init_post.save()
		init_post.save()
		
		init_post=new Post()
		init_post.no=4
		a=Role.get(2)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="西安市市本级房管局"
		init_post.unit="xassbj"
		init_post.operater="tby"
		b=Acount.get(2)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=5
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=6
		init_post.postName="碑林区财政局审核员"
		init_post.unit="blqczj"
		init_post.operater="shy"
		b=Acount.get(4)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=6
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="碑林区财政局填报员"
		init_post.unit="blqczj"
		init_post.operater="tby"
		b=Acount.get(4)
		init_post.setAcount(b)
		init_post.save()

		init_post=new Post()
		init_post.no=7
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=8
		init_post.postName="未央区财政局审核员"
		init_post.unit="wyqczj"
		init_post.operater="shy"
		b=Acount.get(5)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=8
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="未央区财政局填报员"
		init_post.unit="wyqczj"
		init_post.operater="tby"
		b=Acount.get(5)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=9
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=10
		init_post.postName="莲湖区财政局审核员"
		init_post.unit="lhqczj"
		init_post.operater="shy"
		b=Acount.get(6)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=10
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="莲湖区财政局填报员"
		init_post.unit="lhqczj"
		init_post.operater="tby"
		b=Acount.get(6)
		init_post.setAcount(b)
		init_post.save()

		init_post=new Post()
		init_post.no=11
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=12
		init_post.postName="雁塔区财政局审核员"
		init_post.unit="ytqczj"
		init_post.operater="shy"
		b=Acount.get(7)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=12
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="雁塔区财政局填报员"
		init_post.unit="tyqczj"
		init_post.operater="tby"
		b=Acount.get(7)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=13
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=14
		init_post.postName="新城区财政局审核员"
		init_post.unit="xcqczj"
		init_post.operater="shy"
		b=Acount.get(8)
		init_post.setAcount(b)
		init_post.save()
	

		init_post=new Post()
		init_post.no=14
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="新城区财政局填报员"
		init_post.unit="xcqczj"
		init_post.operater="tby"
		b=Acount.get(8)
		init_post.setAcount(b)
		init_post.save()


		init_post=new Post()
		init_post.no=15
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=16
		init_post.postName="灞桥区财政局审核员"
		init_post.unit="bqqczj"
		init_post.operater="shy"
		b=Acount.get(9)
		init_post.setAcount(b)
		init_post.save()
	
	
		init_post=new Post()
		init_post.no=16
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="灞桥区财政局填报员"
		init_post.unit="bqqczj"
		init_post.operater="tby"
		b=Acount.get(9)
		init_post.setAcount(b)
		init_post.save()
		
		
		init_post=new Post()
		init_post.no=17
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=18
		init_post.postName="长安区财政局审核员"
		init_post.unit="caqczj"
		init_post.operater="shy"
		b=Acount.get(10)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=18
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="长安区财政局填报员"
		init_post.unit="caqczj"
		init_post.operater="tby"
		b=Acount.get(10)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=19
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=20
		init_post.postName="临潼区财政局审核员"
		init_post.unit="ltqczj"
		init_post.operater="shy"
		b=Acount.get(11)
		init_post.setAcount(b)
		init_post.save()
		
		
		init_post=new Post()
		init_post.no=20
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="临潼区财政局填报员"
		init_post.unit="ltqczj"
		init_post.operater="tby"
		b=Acount.get(11)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=21
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=22
		init_post.postName="阎良区财政局审核员"
		init_post.unit="blqczj"
		init_post.operater="shy"
		b=Acount.get(12)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=22
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="阎良区财政局填报员"
		init_post.unit="blqczj"
		init_post.operater="tby"
		b=Acount.get(12)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=23
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=24
		init_post.postName="户县区财政局审核员"
		init_post.unit="hxqczj"
		init_post.operater="shy"
		b=Acount.get(13)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=24
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="户县区财政局填报员"
		init_post.unit="blqczj"
		init_post.operater="tby"
		b=Acount.get(13)
		init_post.setAcount(b)
		init_post.save()

		init_post=new Post()
		init_post.no=25
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=26
		init_post.postName="蓝田县区财政局审核员"
		init_post.unit="ltxqczj"
		init_post.operater="shy"
		b=Acount.get(14)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=26
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="蓝田县区财政局填报员"
		init_post.unit="ltxqczj"
		init_post.operater="tby"
		b=Acount.get(14)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=27
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=28
		init_post.postName="周至县区财政局审核员"
		init_post.unit="zzxqczj"
		init_post.operater="shy"
		b=Acount.get(15)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=28
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="周至县区财政局填报员"
		init_post.unit="zzxqczj"
		init_post.operater="tby"
		b=Acount.get(15)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=29
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=30
		init_post.postName="高陵县区财政局审核员"
		init_post.unit="glxqczj"
		init_post.operater="shy"
		b=Acount.get(16)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=30
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="高陵县区财政局填报员"
		init_post.unit="glxqczj"
		init_post.operater="tby"
		b=Acount.get(16)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=31
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=32
		init_post.postName="经开开发区财政局审核员"
		init_post.unit="jkkfqczj"
		init_post.operater="shy"
		b=Acount.get(17)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=32
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="经开开发区财政局填报员"
		init_post.unit="jkkfqczj"
		init_post.operater="tby"
		b=Acount.get(17)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=33
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=34
		init_post.postName="高新开发区财政局审核员"
		init_post.unit="jfkfqczj"
		init_post.operater="shy"
		b=Acount.get(18)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=34
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="高新开发区财政局填报员"
		init_post.unit="gxkfqczj"
		init_post.operater="tby"
		b=Acount.get(18)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=35
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=36
		init_post.postName="曲江开发区财政局审核员"
		init_post.unit="qjkfqczj"
		init_post.operater="shy"
		b=Acount.get(19)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=36
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="曲江开发区财政局填报员"
		init_post.unit="qjkfqczj"
		init_post.operater="tby"
		b=Acount.get(19)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=37
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=38
		init_post.postName="航天基地开发区财政局审核员"
		init_post.unit="htjdkfqczj"
		init_post.operater="shy"
		b=Acount.get(20)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=38
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="航天基地开发区财政局填报员"
		init_post.unit="htjdkfqczj"
		init_post.operater="tby"
		b=Acount.get(20)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=39
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=40
		init_post.postName="航空基地开发区财政局审核员"
		init_post.unit="hkjdkfqczj"
		init_post.operater="shy"
		b=Acount.get(21)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=40
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="航空基地开发区财政局填报员"
		init_post.unit="hkjdkfqczj"
		b=Acount.get(21)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=41
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=42
		init_post.postName="浐灞开发区财政局审核员"
		init_post.unit="cbkfqczj"
		init_post.operater="shy"
		b=Acount.get(22)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=42
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="浐灞开发区区财政局填报员"
		init_post.unit="cbkfqczj"
		init_post.operater="tby"
		b=Acount.get(22)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=43
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=44
		init_post.postName="沣东新区财政局审核员"
		init_post.unit="fdxqkfqczj"
		init_post.operater="shy"
		b=Acount.get(23)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=44
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="沣东新区财政局填报员"
		init_post.unit="fdxqkfqczj"
		init_post.operater="tby"
		b=Acount.get(23)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=45
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=46
		init_post.postName="国际港务开发区财政局审核员"
		init_post.unit="gjgwkfqczj"
		init_post.operater="shy"
		b=Acount.get(24)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=46
		a=Role.get(3)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="国际港务开发区财政局填报员"
		init_post.unit="gjgwqczj"
		init_post.operater="tby"
		b=Acount.get(24)
		init_post.setAcount(b)
		init_post.save()
		
		
		init_post=new Post()
		init_post.no=47
		a=Role.get(4)
		init_post.setRole(a)
		init_post.postName="西安市市本级建设单位A"
		init_post.parentPost=1
		init_post.unit="xassbjjsdwA"
		init_post.operater="tby"
		b=Acount.get(25)
		init_post.setAcount(b)
		init_post.save()

		init_post=new Post()
		init_post.no=48
		a=Role.get(4)
		init_post.setRole(a)
		init_post.parentPost=1
		init_post.postName="西安市市本级建设单位B"
		init_post.unit="xassbjjsdwA"
		init_post.operater="tby"
		b=Acount.get(26)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=49
		a=Role.get(4)
		init_post.setRole(a)
		init_post.postName="碑林区建设单位A"
		init_post.parentPost=5
		init_post.unit="blqjsdwA"
		init_post.operater="tby"
		b=Acount.get(27)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=50
		a=Role.get(4)
		init_post.setRole(a)
		init_post.parentPost=5
		init_post.postName="碑林区建设单位B"
		init_post.unit="blqjsdwA"
		init_post.operater="tby"
		b=Acount.get(28)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=51
		a=Role.get(4)
		init_post.setRole(a)
		init_post.postName="雁塔区建设单位A"
		init_post.parentPost=11
		init_post.unit="ytqjsdwA"
		init_post.operater="tby"
		b=Acount.get(29)
		init_post.setAcount(b)
		init_post.save()
		
		init_post=new Post()
		init_post.no=52
		a=Role.get(4)
		init_post.setRole(a)
		init_post.parentPost=11
		init_post.postName="雁塔区建设单位B"
		init_post.unit="ytqjsdwA"
		init_post.operater="tby"
		b=Acount.get(30)
		init_post.setAcount(b)
		init_post.save()

		//post表建完
//

		def x
		def y
		def init_registration
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(1)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(2)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(3)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(4)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(5)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(6)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(7)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(8)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(9)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(10)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(11)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(12)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(1)
		init_registration.setRole(x)
		y=Form.get(13)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(1)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(2)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(3)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(4)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(5)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(6)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(7)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(8)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(9)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(10)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(11)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(12)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(2)
		init_registration.setRole(x)
		y=Form.get(13)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(1)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(2)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(3)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(4)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(5)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(6)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(7)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(8)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(9)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(10)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(11)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(12)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(3)
		init_registration.setRole(x)
		y=Form.get(13)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(1)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(2)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(6)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(7)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(10)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(11)
		init_registration.setForm(y)
		init_registration.save()
		init_registration=new Registration()
		x=Role.get(4)
		init_registration.setRole(x)
		y=Form.get(13)
		init_registration.setForm(y)
		init_registration.save()
	
	//registration表建完
/*
		def init_au=new Authority()
		def tt
		def zz
		init_au.authority=1
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(1)
		init_au.setPost(zz)
		init_au.save()
*/
		
		//authority表建完
		authority();
	}
	/**
	 * 添加旧数据
	 */
	
	def dynamic
	public static old_data()
	{
		//
				def old_time=[2,3,4,7,8,9]
				def ppp_num=6
				def startyear
				def startmonth=1
				def static_year=2013
				def static_month
				//def xx
				def cal=Calendar.getInstance()
				for (table in old_time)
					{
				    if (table < ppp_num)
						{
						startyear=2006
						startmonth=11
						}	
					else
						{
						startyear=2010
						startmonth=11	
						}
					while (startyear<static_year)
							{
								cal.set(Calendar.YEAR,startyear)
								cal.set(Calendar.MONTH,startmonth)
								println(cal.getTime())
								def whynot=Authority.createCriteria()
								def need_id_list=whynot.list
								{
									and{
										form{
											eq("no",table)
											}
										eq("authority",(short)1)
										}
								}
								if(need_id_list.size()>0)
								{
									for(i in 0..need_id_list.size()-1)
									{
										def plan_times=new PlanTime()
										plan_times.tableId=table
										plan_times.planTime=cal.getTime()
										plan_times.postId=need_id_list.get(i).postId
										plan_times.save()
									}
								}
								startyear++
							}
					}
	
	}
	
	private static authority(){
		def init_au
		
		def tt
		def zz
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(1)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(2)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(3)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(4)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(5)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(6)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(7)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(8)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(9)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(10)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(11)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(12)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(13)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(14)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(15)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(16)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(17)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(18)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(19)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(20)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(21)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(22)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(23)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(24)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(25)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(26)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(27)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(28)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(29)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(30)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(31)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(32)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(33)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(34)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(35)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(36)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(37)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(38)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(39)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(40)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(41)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(42)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(43)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(44)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(45)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=2
		tt=Post.get(46)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(3) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(4) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(5) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(8) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(9) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(47)
		init_au.setPost(tt)
		zz=Form.get(12) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(48)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(49)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(50)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(51)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(52)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(1) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(2) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(6) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(7) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(10) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(11) 
		init_au.setForm(zz) 
		init_au.save()
		
		init_au=new Authority()
		init_au.authority=1
		tt=Post.get(53)
		init_au.setPost(tt)
		zz=Form.get(13) 
		init_au.setForm(zz) 
		init_au.save()


	}
	
	public static imitate()
		{		
				def cc=[6,3,3,3,3,6,3,3,3,0,3,3,3]
				def cal=Calendar.getInstance()
				def now_year=cal.get(Calendar.YEAR)	
				def now_month=0	
				def now_date=new Date()
				Calendar cac
				
				for (i in 1..12)		
					{
						cal.set(Calendar.MONTH,now_month)
						for (j in 1..13)
							{
							if ((cc.get(j-1)!=0)&&now_month%(cc.get(j-1))==0)
								{
									def whynot=Authority.createCriteria()
									def need_id_list=whynot.list
									{
										and{
											form{
												eq("no",j)
												}
											eq("authority",(short)1)
											}
									}
									if(need_id_list.size()>0)
									{
										for(k in 0..need_id_list.size()-1)
										{
											//println need_id_list[i]
											def plan_times=new PlanTime()
											def recordTime=new Record()
											cac=Calendar.getInstance()
											cac.setTime(now_date)
											recordTime.year=cac.get(Calendar.YEAR)
											recordTime.month=cac.get(Calendar.MONTH)+1
											recordTime.save()
											plan_times.tableId=j
											plan_times.planTime=cal.getTime()
											plan_times.postId=need_id_list.get(k).postId
											plan_times.save()
										}
									}
									
								}
							}
							now_month++
//							cal.set(Calendar.YEAR,now_year)
//							cal.set(Calendar.MONTH,now_month-1)
							
					}
		}
	
	}
