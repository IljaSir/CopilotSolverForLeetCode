impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut res = String::new();
        let mut k = k;
        let mut row = destination[0];
        let mut col = destination[1];
        while row > 0 || col > 0 {
            if row == 0 {
                res.push('H');
                col -= 1;
            } else if col == 0 {
                res.push('V');
                row -= 1;
            } else {
                let num = Self::combination(row + col - 1, row - 1);
                if k > num {
                    res.push('V');
                    k -= num;
                    row -= 1;
                } else {
                    res.push('H');
                    col -= 1;
                }
            }
        }
        res
    }
    
    fn combination(n: i32, k: i32) -> i32 {
        let mut res = 1;
        for i in 0..k {
            res = res * (n - i) / (i + 1);
        }
        res
    }
}