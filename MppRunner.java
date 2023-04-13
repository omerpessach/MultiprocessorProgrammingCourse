// main class name must be MppRunner for execution on the multicore server.
// don't submit this class! it's only for multicore execution
//
// to execute: compile these files and place both .class files in shared dir
//	server generates mpp.out file with results (standard output + error)
//	to execute again: delete mpp.out
class MppRunner
{
	public static void main(String args[])
	{
		for (int i = 1;i <= 64; i <<=1)
		{
			Ex1q8.main(new String[] { Integer.toString(i) });
		}
    }
}
