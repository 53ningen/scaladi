package com.github.gomi.scaladi

import com.google.inject.{Provides, Binder, Module, Guice}
import org.specs2.mutable.Specification

class UserServiceTest extends Specification {

  "UserService" should {

    "getUserName" in {
      val userService = Guice.createInjector().getInstance(classOf[UserService])
      userService.getUserName mustEqual  "gomi_ningen"
    }

    "getUserName" in {
      // DISettingModuleを作り込むことにより、
      // 実行時に実装クラスの差し替えや実装クラスに与えるパラメータの差し替えなどがわりと柔軟にできる
      val injector = Guice.createInjector(new DISettingModule)
      val userService = injector.getInstance(classOf[UserService])
      userService.getUserName mustEqual "mockmock"
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
