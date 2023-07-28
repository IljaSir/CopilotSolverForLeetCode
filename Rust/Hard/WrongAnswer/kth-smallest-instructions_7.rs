impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut res = String::new();
        let mut k = k;
        let mut row = destination[0];
        let mut col = destination[1];
        for i in 0..(row + col) {
            if col == 0 {
                res.push_str("H");
                continue;
            }
            let mut count = 0;
            let mut j = 0;
            while j <= col {
                count += Self::c(row + col - i - 1, row - j - 1);
                j += 1;
            }
            if count >= k {
                res.push_str("V");
                row -= 1;
            } else {
                res.push_str("H");
                col -= 1;
                k -= count;
            }
        }
        res
    }
    
    fn c(n: i32, m: i32) -> i32 {
        let mut res = 1;
        for i in 0..m {
            res *= n - i;
            res /= i + 1;
        }
        res
    }
}