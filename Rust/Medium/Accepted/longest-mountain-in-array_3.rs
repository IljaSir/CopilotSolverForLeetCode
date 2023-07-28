impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut i = 0;
        let mut ans = 0;
        while i < n {
            let mut j = i;
            if j + 1 < n && arr[j] < arr[j + 1] {
                while j + 1 < n && arr[j] < arr[j + 1] {
                    j += 1;
                }
                if j + 1 < n && arr[j] > arr[j + 1] {
                    while j + 1 < n && arr[j] > arr[j + 1] {
                        j += 1;
                    }
                    ans = ans.max(j - i + 1);
                }
            }
            i = j.max(i + 1);
        }
        ans as i32
    }
}