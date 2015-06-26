package com.github.gomi.scaladi

class MockUserRepository extends UserRepository {

  override def getUser: String = "mockmock"

}
