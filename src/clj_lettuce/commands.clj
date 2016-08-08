(ns clj-lettuce.commands
  (:refer-clojure :exclude [get set]))

(defprotocol RedisConn
  ""
  (redis-cli [this redis-uri])
  (stateful-conn [this cli])
  (close-conn [this conn])
  (shutdown [this cli]))

(defmulti mk-commands
  (fn [type redis-conn] type))

(defprotocol StringsCommands
  "Redis Strings Commands"
  (get [this k]   "Gets the value for k")
  (set [this k v] "Sets k to the v")
  (mget [this ks] "Gets the values for the col of keys"))

(defprotocol HashCommands
  "Redis Hash Commands"
  (hdel [this k fs] "")
  (hexists [this k f] "")
  (hget [this k f] "")
  (hincrby [this k f a] "")
  (hincrbyfloat [this k f a] "")
  (hgetall [this k] "")
  (hkeys [this k] "")
  (hlen [this k] "")
  (hmget [this k fs] "")
  (hmset [this k m] "")
  (hscan [this k] "")
  (hset [this k f v] "")
  (hsetnx [this k f v] "")
  (hstrlen [this k f] "")
  (hvals [this k] ""))
