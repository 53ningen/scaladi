package com.github.gomi.scaladi

import com.google.inject.Inject

// プロパティにインジェクトしたいときはこんなかんじ
class UserService @Inject() (userRepository: UserRepository) {

  def getUserName: String = userRepository.getUser

}
