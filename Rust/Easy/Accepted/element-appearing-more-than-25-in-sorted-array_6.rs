impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let mut cnt = 1;
        let mut ans = arr[0];
        for i in 1..arr.len() {
            if arr[i] == ans {
                cnt += 1;
            } else {
                ans = arr[i];
                cnt = 1;
            }
            if cnt * 4 > arr.len() {
                return ans;
            }
        }
        ans
    }
}