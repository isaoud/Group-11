/**
 * The following class shall provide a library for sorting algorithms
 */
public class Sorting2 {

    /**
     * These methods implement merge sort
     */
    public <T extends Comparable<? super T>> void mergeSortI(T[] a) {
        mergeSort(a,0,a.length-1);
    }
    public <T extends Comparable<? super T>> void mergeSort(T[] a, int l, int r) {
        /**
         *  TODO: Enter your implementation here
         */
        int m;
        if (l < r) {
            m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }

    }
    public <T extends Comparable<? super T>> void merge(T[] a, int l, int m, int r) {
        /**
         *  TODO: Enter your implementation here
         */
        T[] b = a.clone(); //Use this array as the temporary array in the algorithm
        int i, j, k;
        i = l;
        while (i <= m) {
            b[i] = a[i];
            i = i + 1;
        }
        j = m + 1;
        while (j <= r) {
            b[r+m+1-j] = a[j];
            j = j + 1;
        }
        i = l; j = r; k = l;
        while (k <= r) {
            if (b[i].compareTo(b[j]) < 0) {
                a[k] = b[i];
                i = i + 1;
            } else {
                a[k] = b[j];
                j = j - 1;
            }
            k = k + 1;
        }
    }

    /**
     * These methods implement quick sort
     */
    public <T extends Comparable<? super T>> void quickSortI(T[] a) {
        quickSort(a, 0, a.length-1);
    }
    public <T extends Comparable<? super T>> void quickSort(T[] a, int i, int j) {
        /**
         *  TODO: Enter your implementation here
         */
        int p;
        if (i < j) {
            p = partition(a, i, j);
            quickSort(a, i, p - 1);
            quickSort(a, p + 1, j);
        }
    }
    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * !!!! Note: Instead of setting p, partition shall return p !!!!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */
    public <T extends Comparable<? super T>> int partition(T[] a, int i, int j) {
        int p, q;
        T x, h;
        /**
         *  TODO: Enter your implementation here
         */
        x = a[j];
        p = i;
        q = j- 1;
        while (p <= q) {
            if (a[p].compareTo(x) < 0) {
                p = p + 1;
            } else {
                if (a[q].compareTo(x) > 0) {
                    q = q - 1;
                } else {
                    h = a[p];
                    a[p] = a[q];
                    a[q] = h;
                    p = p + 1;
                    q = q - 1;
                }
            }
        }
        a[j] = a[p];
        a[p] = x;
        return p;
    }

    /**
     * These methods implement heap sort
     */
    public <T extends Comparable<? super T>> void heapSort(T[] a) {
        /**
         *  TODO: Enter your implementation here
         */
        int i, n = a.length-1;
        T h;
        i = n / 2;
        while (i >= 1) {
            sift(a, i, n);
            i = i - 1;
        }
        i = n;
        while (i != 1) {
            h = a[i];
            a[i] = a[1];
            a[1] = h;
            i = i - 1;
            sift(a, 1, i);
        }
    }

    public <T extends Comparable<? super T>> void sift(T[] a, int l, int r) {
        /**
         *  TODO: Enter your implementation here
         */
        int k, j;
        T h;
        k = l;
        while (!((2*k > r || a[k].compareTo(a[2*k]) >= 0) && (2*k + 1 > r || a[k].compareTo(a[2*k + 1]) >= 0))){
            j = 2 * k;
            if (j < r && a[j].compareTo(a[j+1]) < 0) {
                j = j + 1;
            }
            h = a[k];
            a[k] = a[j];
            a[j] = h;
            k = j;
        }
    }

    /**
     * Test the implementations of merge sort, quick sort and heap sort using the array a
     */
    public <T extends Comparable<? super T>> void sortTester(T[] a) {
        //Clone the given array to memorize before state
        T[] b = a.clone();

        System.out.println("Merge sort "+arrayToString(a));
        mergeSortI(a);
        System.out.println(arrayToString(a));

        a = b.clone();
        System.out.println("Quick sort "+arrayToString(a));
        quickSortI(a);
        System.out.println(arrayToString(a));

        a = b.clone();
        System.out.println("Heap sort "+arrayToString(a));
        heapSort(a);
        System.out.println(arrayToString(a));
    }

    /**
     * The method randomIntegerArray returns an integer array with size n and randomly chosen integer values.
     */
    private Integer[] randomIntegerArray(int n) {
        assert n>=1 : "Precondition of randomIntegerArray not satisfied";
        Integer[] r = new Integer[n];
        for (int i=0; i<n; i++)
            r[i] = new Double((Math.random()*10000)%100).intValue();
        return r;
    }

    /**
     * The method arrayToString returns a String representation of the array a
     */
    private String arrayToString(Object[] a) {
        String r="[";
        if(a.length>0)
            r+=a[0];
        for(int i=1; i<a.length; i++)
            r+=", "+a[i];
        r+="]";
        return r;
    }


    /**
     * The main method initiates the test
     */
    public static void main(String[] args) {
        Sorting2 s = new Sorting2();
        Integer[] a1 = {5,4,3,2,1};
        Integer[] a2 = {2,1,2,2,1};
        Integer[] a3 = s.randomIntegerArray(10);
        String[] s1 = {"Apfel", "Apfelsine", "Orange", "Banane"};
        //The first paragraph of the preface of the CSP book of C.A.R. Hoare
        String[] s2 = {"This", "is", "a", "book", "for", "the", "aspiring", "programmer", "the",
                "programmer", "who", "aspires", "to", "greater", "understanding", "and",
                "skill", "in", "the", "practice", "of", "an", "intellectually",
                "demanding", "profession", "It", "is", "designed", "to", "appeal",
                "first", "to", "a", "natural", "sense", "of", "curiosity", "which", "is",
                "aroused", "by", "a", "new", "approach", "to", "a", "familiar", "topic",
                "The", "approach", "is", "illustrated", "by", "a", "host", "of",
                "examples", "drawn", "from", "a", "wide", "range", "of", "applications",
                "from", "vending", "machines", "through", "fairy", "stories", "and",
                "games", "to", "comuter", "operating", "systems", "The", "treatment",
                "is", "based", "on", "a", "mathematical", "theory", "which", "is",
                "described", "by", "a", "systematic", "collection", "of", "algebraic",
                "laws"};
        s.sortTester(a1);
        System.out.println();
        s.sortTester(a2);
        System.out.println();
        s.sortTester(a3);
        System.out.println();
        s.sortTester(s1);
        System.out.println();
        s.sortTester(s2);

    }

}



