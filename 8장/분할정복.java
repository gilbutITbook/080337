private static int binarySearch(int[] arr, int target) {
    int start = 0;  // inclusive
    int end = arr.length;  // exclusive

    while (end > start) {
        int mid = (start + end) / 2;
        int value = arr[mid];

        if (value == target) {
            return mid;
        } else if (value > target) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }

    return -1;
}

