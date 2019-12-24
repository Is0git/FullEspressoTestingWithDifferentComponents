package com.android.espressowithdifferentcomponents

import org.junit.runner.RunWith
import org.junit.runners.Suite
@RunWith(Suite::class)
@Suite.SuiteClasses(ActivityRuleTest::class, ActivityScenarioTest::class)
class ActivityTestSuite