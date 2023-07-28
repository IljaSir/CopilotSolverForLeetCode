class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        // we can use binary search to find the first bad version
        // if the version is bad, we go to the left
        // if the version is good, we go to the right
        // we need to find the first version that is bad
        // if the version is bad, we need to check if the previous version is good
        // if the version is good, we need to check if the next version is bad
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // check if the previous version is good
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                // if the previous version is bad, we need to go to the left
                right = mid - 1;
            } else {
                // if the version is good, we need to check if the next version is bad
                // if the next version is bad, we need to return the next version
                if (isBadVersion(mid + 1)) {
                    return mid + 1;
                }
                // if the next version is good, we need to go to the right
                left = mid + 1;
            }
        }
        return 1;
    }
}