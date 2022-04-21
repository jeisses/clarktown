(ns clarktown.renderers.heading-block-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [clarktown.renderers.heading-block :as heading-block]))


(deftest atx-heading-renderer-test
  (testing "Hashbang heading block that's a H1"
    (is (= "<h1>This is a heading block.</h1>"
           (heading-block/render "# This is a heading block." nil nil))))

  (testing "Hashbang heading block that's a H2"
    (is (= "<h2>This is a heading block.</h2>"
           (heading-block/render "## This is a heading block." nil nil))))

  (testing "Hashbang heading block that's a H3"
    (is (= "<h3>This is a heading block.</h3>"
           (heading-block/render "### This is a heading block." nil nil))))

  (testing "Hashbang heading block that's a H4"
    (is (= "<h4>This is a heading block.</h4>"
           (heading-block/render "#### This is a heading block." nil nil))))

  (testing "Hashbang heading block that's a H5"
    (is (= "<h5>This is a heading block.</h5>"
           (heading-block/render "##### This is a heading block." nil nil)))))


(deftest settext-heading-renderer-text
  (testing "Settext heading block that's a H1"
    (is (= "<h1>This is a heading block.</h1>"
           (heading-block/render "This is a heading block.\n=========" nil nil))))

  (testing "Settext heading block that's a H1 spanning multiple lines"
    (is (= "<h1>This is a \nheading block spanning multiple lines.</h1>"
           (heading-block/render "This is a \nheading block spanning multiple lines.\n========" nil nil))))

  (testing "Settext heading block that's a H2"
    (is (= "<h2>This is a heading block.</h2>"
           (heading-block/render "This is a heading block.\n---------" nil nil))))

  (testing "Settext heading block that's a H2 spanning multiple lines"
    (is (= "<h2>This is a \nheading block spanning multiple lines.</h2>"
           (heading-block/render "This is a \nheading block spanning multiple lines.\n--------" nil nil)))))