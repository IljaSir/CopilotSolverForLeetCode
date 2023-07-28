impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut longest = 0;
        let mut i = 1;
        while i < arr.len() {
            let mut up = false;
            let mut down = false;
            let mut length = 1;
            while i < arr.len() && arr[i] > arr[i-1] {
                up = true;
                i += 1;
                length += 1;
            }
            while i < arr.len() && arr[i] < arr[i-1] {
                down = true;
                i += 1;
                length += 1;
            }
            if up && down {
                longest = longest.max(length);
            }
            while i < arr.len() && arr[i] == arr[i-1] {
                i += 1;
            }
        }
        longest
    }
}