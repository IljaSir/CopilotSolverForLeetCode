impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut res = String::new();
        let mut k = k;
        let mut row = destination[0];
        let mut col = destination[1];
        for _ in 0..(row + col) {
            let s = Solution::combination(row + col - 1, col - 1);
            if k <= s {
                res.push('H');
                col -= 1;
            } else {
                res.push('V');
                k -= s;
                row -= 1;
            }
        }
        res
    }
    
    pub fn combination(n: i32, k: i32) -> i32 {
        let mut res = 1;
        for i in 0..k {
            res = res * (n - i) / (i + 1);
        }
        res
    }
}