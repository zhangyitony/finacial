dataSource {
    pooled = true
    driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    username = "sa"
    password = "xx"
	dialect = "org.hibernate.dialect.SQLServerDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:sqlserver://192.168.2.194:1433;databaseName=xianFinacial"
			  url = "jdbc:sqlserver://192.168.2.194:1433;databaseName=test_dev_chen"
		}
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:sqlserver://192.168.2.194:1433;databaseName=xianFinacial"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:sqlserver://192.168.2.194:1433;databaseName=xianFinacial"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800001
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
