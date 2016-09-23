import org.neo4j.driver.v1.{AuthTokens, GraphDatabase, StatementResult}

/**
  * Created by sharanyak on 22/9/16.
  */
object Dao {

  def persistEntity(image:Image):Int={

    val driver = GraphDatabase.driver("bolt://localhost/7474", AuthTokens.basic("neo4j","pramati123"))
    val session = driver.session
    val script = s"CREATE (user:Image {imageId:'${image.imageId}',state:'${image.state}',ownerId:${image.ownerId}," +
      s"publicValue:'${image.publicValue}',architecture:'${image.architecture}',imageType:'${image.imageType}'," +
      s"platform:'${image.platform}'" +
      s",imageOwnerAlias:'${image.imageOwnerAlias}',name:'${image.name}',description:'${image.description}'," +
      s"rootDeviceType:'${image.rootDeviceType}',rootDeviceName:'${image.rootDeviceName}',version:'${image.version}'})"
    val result: StatementResult = session.run(script)
    session.close()
    driver.close()
    result.consume().counters().nodesCreated()



  }

}
