package net.torrypubrepo.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Pagination
{
    private static final int MAX_LIST_SIZE = 1000;
    private static final int MINIMUM_ITEM_PER_PAGE = 20;
    private static final int MAX_ITEM_PER_PAGE = 40;
    private static final List<Integer> randomLists = new ArrayList<>();
    private static IntStream intStream;
    // Generate Mock List of Numbers -- This can be list pulled from Server etc
    static {
        for (int i = 1; i <= MAX_LIST_SIZE; i++)
            randomLists.add(i);
        }


        public Pagination()
        {

        }

        public static void main(String[] args)
        {
            Pagination pagination = new Pagination();

           // System.out.println("------------ Total Page ------------------ " + pagination.getTotal_NumberOfPages(25));

            System.out.println();

           // System.out.println("----------- Go to Page E.g. 35 and 20 items per page");
           // goToPage(34, 20);

            System.out.println("----------- Print 20 Items Per Page ----------------");
            for (int p = 0; p < randomLists.size() / MINIMUM_ITEM_PER_PAGE; p++)
            {
                // Add 1 to account for index starting from 0
                System.out.println("---------------------Page "+(p+1)+"--------------------------------");
                pagination.scroll_Pages(p+1, p * MINIMUM_ITEM_PER_PAGE, MINIMUM_ITEM_PER_PAGE);

            }//End for


        }//End main

        // Get Number of Pages based of Items Per Page
        private int getTotal_NumberOfPages(int itemPerPage)
        {
            return randomLists.size()/itemPerPage;
        }
        public void scroll_Pages(int pageNum, int from, int numOfItemPerList)
        {
            // Create Stream From List
            intStream = randomLists.stream().mapToInt(a -> a);
            // Print Stream
            intStream.skip(from).limit(numOfItemPerList).forEach(System.out::println);
            System.out.println("-------------------------------------------------------");

        }//End scroll_Pages

        // Navigate to Specific Page
        public static void goToPage(int pageNumber, int numberOfItemPerList)
        {
            // Create Stream From List
            intStream = randomLists.stream().mapToInt(a -> a);
            // Print Stream
            intStream.skip(pageNumber*numberOfItemPerList).limit(numberOfItemPerList).forEach(System.out::println);
        }//End goToPage

}//End Pagination
