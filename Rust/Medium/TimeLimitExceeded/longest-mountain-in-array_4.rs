impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut longest = 0;
        let mut i = 1;
        while i < arr.len() {
            let mut j = i;
            if arr[i - 1] < arr[i] {
                while j < arr.len() && arr[j - 1] < arr[j] {
                    j += 1;
                }
                if j < arr.len() && arr[j - 1] > arr[j] {
                    while j < arr.len() && arr[j - 1] > arr[j] {
                        j += 1;
                    }
                    longest = longest.max(j - i + 1);
                } else {
                    j += 1;
                }
            }
            i = j;
        }
        longest as i32
    }
}