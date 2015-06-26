package com.github.gomi.scaladi

import com.google.inject.ImplementedBy

// ImplementedBy でデフォルト実装クラスを指定している
@ImplementedBy(classOf[DefaultUserRepository])
trait UserRepository {

  def getUser: String

}
