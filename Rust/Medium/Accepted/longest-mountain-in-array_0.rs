impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut ans = 0;
        let mut base = 0;
        while base < n {
            let mut end = base;
            if end + 1 < n && arr[end] < arr[end + 1] {
                while end + 1 < n && arr[end] < arr[end + 1] {
                    end += 1;
                }
                if end + 1 < n && arr[end] > arr[end + 1] {
                    while end + 1 < n && arr[end] > arr[end + 1] {
                        end += 1;
                    }
                    ans = ans.max(end - base + 1);
                }
            }
            base = end.max(base + 1);
        }
        ans as i32
    }
}