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
      // DISettingModuleを作り込むことにより、
      // 実行時に実装クラスの差し替えや実装クラスに与えるパラメータの差し替えなどがわりと柔軟にできる
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
      // たとえばここを、乱数を発生させ奇数だったらDefault、
      // 偶数だったらMockの実装を使うみたいな実装にすることができる

    }

  }

}
