package com.github.gomi.scaladi

import com.google.inject._

class DefaultUserRepositoryTest extends org.specs2.mutable.Specification {

  "DefaultUserRepository" should {

    "getUser" in {
      val injector = Guice.createInjector()
      val userRepository = injector.getInstance(classOf[UserRepository])
      userRepository.getUser mustEqual "gomi_ningen"
    }

    "change UserRepository implementation in runtime" in {
      val injector = Guice.createInjector(new DISettingModule)
      val userRepository = injector.getInstance(classOf[UserRepository])
      userRepository.getUser mustEqual "mockmock"
    }

    class DISettingModule extends Module {

      override def configure(binder: Binder): Unit = {
      }

      // 関数なので設定値によって用いる実装を変えたり、
      // 実装に与えるパラメータを変えたりできる
      @Provides
      def getUserRepository: UserRepository = new MockUserRepository

    }

  }

}
