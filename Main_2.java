import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSortExample {
    static int[] myArr;

    static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = Arrays.copyOfRange(arr, start, end + 1);

        int i = 0, j = mid - start + 1, k = start;
        while (i <= mid - start && j <= end - start) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k++] = tempArr[i++];
            } else {
                arr[k++] = tempArr[j++];
            }
        }
        while (i <= mid - start) {
            arr[k++] = tempArr[i++];
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void randomGenerator(int n) {
        myArr = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int randomNumber = random.nextInt(n) + 1;
            System.out.print(randomNumber + " ");
            myArr[i] = randomNumber;
        }
        System.out.println();
        mergeSort(myArr, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many elements do you want to generate: ");
        int n = scanner.nextInt();

        System.out.print("Generated values: ");
        long startTime = System.nanoTime();
        randomGenerator(n);
        long endTime = System.nanoTime();

        System.out.println("\nAfter sorting: " + Arrays.toString(myArr));

        long duration = (endTime - startTime) / 1000; // Convert nanoseconds to microseconds
        System.out.println("Time taken by function: " + duration + " microseconds");
    }
}
//  2.oqucik sort
// import java.util.Random;
// import java.util.Scanner;

// public class QuickSortExample {
//     static int[] myArr;

//     static int partition(int[] arr, int start, int end) {
//         // Choose the first element as the pivot
//         int pivot = arr[start];
//         int pivotIndex = start;

//         // Count elements less than or equal to the pivot
//         for (int i = start + 1; i <= end; i++) {
//             if (arr[i] <= pivot)
//                 pivotIndex++;
//         }

//         // Move the pivot to its correct position
//         swap(arr, pivotIndex, start);

//         // Arrange elements less than the pivot to its left and greater to its right
//         int i = start, j = end;
//         while (i < pivotIndex && j > pivotIndex) {
//             while (arr[i] <= pivot) i++;
//             while (arr[j] > pivot) j--;

//             // Swap elements to maintain the partition
//             if (i < pivotIndex && j > pivotIndex) {
//                 swap(arr, i++, j--);
//             }
//         }

//         return pivotIndex;
//     }

//     static void quickSort(int[] arr, int start, int end) {
//         if (start < end) {
//             int pivotIndex = partition(arr, start, end);

//             // Recursively sort the two partitions
//             quickSort(arr, start, pivotIndex - 1);
//             quickSort(arr, pivotIndex + 1, end);
//         }
//     }

//     static void randomGenerator(int n) {
//         myArr = new int[n];
//         Random random = new Random();

//         // Generate and print random numbers
//         for (int i = 0; i < n; ++i) {
//             int randomNumber = random.nextInt(n) + 1;
//             System.out.print(randomNumber + " ");
//             myArr[i] = randomNumber;
//         }
//         System.out.println();

//         // Sort the array using Quick Sort
//         quickSort(myArr, 0, n - 1);
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("How many elements do you want to generate: ");
//         int n = scanner.nextInt();

//         System.out.print("Generated values: ");
//         long startTime = System.nanoTime();
//         randomGenerator(n);

//         System.out.println("\nAfter sorting: " + arrayToString(myArr));

//         long endTime = System.nanoTime();
//         long duration = (endTime - startTime) / 1000; // Convert nanoseconds to microseconds
//         System.out.println("Time taken by function: " + duration + " microseconds");
//     }

//     static void swap(int[] arr, int i, int j) {
//         // Swap two elements in the array
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     static String arrayToString(int[] arr) {
//         // Convert array to string for printing
//         StringBuilder result = new StringBuilder();
//         for (int i : arr) {
//             result.append(i).append(" ");
//         }
//         return result.toString();
//     }
// } 