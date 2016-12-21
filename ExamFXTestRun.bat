set projectLocation=C:\Program Files (x86)\Jenkins\jobs\ExamFX_SmokeTest_Automation\workspace\ExamFXAutomation
cd %projectLocation%
set classpath=%projectLocation%\lib\*;%projectLocation%\bin;
java org.testng.TestNG examfx_smoketest.xml