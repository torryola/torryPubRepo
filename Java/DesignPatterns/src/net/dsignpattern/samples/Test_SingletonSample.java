package net.dsignpattern.samples;

public class Test_SingletonSample
{
    private static final int MAX_LIST_LENGTH = 50;
    public static void main(String[] args)
    {

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Starting Thread :"+1);
                SingletonObjectSample singletonObjectSample = SingletonObjectSample.getInstance();
                for (int i = 0; i < MAX_LIST_LENGTH; i++)
                {
                    // if (singletonObjectSample.get_ListSize() <= 1)
                    for (int j = 0; j < 5; j++)
                    {
                        singletonObjectSample.set_StringList(String.valueOf(j));
                    }
                    if (singletonObjectSample.get_ListSize() >= 5)
                    {
                        try {
                            System.out.println("Thread 1 is Sleeping ");
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //for (int j = 0; j < 30; j++)
                   // System.out.println(singletonObjectSample.get_StringVal(j));

            }
        });

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Starting Thread :"+2);

                SingletonObjectSample singletonObjectSample = SingletonObjectSample.getInstance();

                for (int i = 0; i < MAX_LIST_LENGTH; i++)
                {
                    if (singletonObjectSample.get_ListSize() > 0)
                    {
                        for (int k = 0; k < 5; k++) {
                            System.out.println(singletonObjectSample.get_StringVal(k));
                            singletonObjectSample.remove_ListItem(k);
                        }
                    }
                    else {
                        try {
                            System.out.println("Thread 2 is Sleeping ");
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread1.start();
        try {
            thread1.join(300);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}//End Test_SingletonSample
