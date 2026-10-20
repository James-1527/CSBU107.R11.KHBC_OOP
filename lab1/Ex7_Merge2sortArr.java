import java.util.Scanner;

public class Ex7_Merge2sortArr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of elements n in first sorted array
        System.out.print("Enter number of elements in first array (n): ");
        int n = sc.nextInt();

        // Step 2: Read n integers into first sorted array
        int[] arr1 = new int[n];
        System.out.println("Enter " + n + " elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Step 3: Input number of elements m in second sorted array
        System.out.print("Enter number of elements in second array (m): ");
        int m = sc.nextInt();

        // Step 4: Read m integers into second sorted array
        int[] arr2 = new int[m];
        System.out.println("Enter " + m + " elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        // Step 5: Merge the two sorted arrays into one sorted array
        int[] merged = mergeSortedArrays(arr1, arr2);

        // Step 6: Print the merged sorted array
        System.out.print("Merged sorted array: ");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]);
            if (i < merged.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }

    // Function to merge two sorted arrays in ascending order
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and add smaller element to merged
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        // Add remaining elements from arr2
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }
}