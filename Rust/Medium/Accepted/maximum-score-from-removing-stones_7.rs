impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut arr = [a, b, c];
        arr.sort();
        let mut ans = 0;
        if arr[0] + arr[1] <= arr[2] {
            ans = arr[0] + arr[1];
        } else {
            ans = (arr[0] + arr[1] + arr[2]) / 2;
        }
        ans
    }
}