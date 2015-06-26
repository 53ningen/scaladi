package com.github.gomi.scaladi

import com.google.inject.ImplementedBy

@ImplementedBy(classOf[DefaultUserRepository])
trait UserRepository {

  def getUser: String

}
