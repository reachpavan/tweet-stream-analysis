package services

import javax.inject.Singleton

/**
  * create by lakshmiarepu on 2019-06-19
  */
@Singleton
class TweetStreamService {

  def getInfo(): Option[String] =
    Some("Hello")
}
