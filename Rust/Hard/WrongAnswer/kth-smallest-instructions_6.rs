impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut k = k as usize;
        let mut result = String::new();
        let mut row = destination[0];
        let mut col = destination[1];
        while row > 0 || col > 0 {
            if row == 0 {
                result.push('H');
                col -= 1;
            } else if col == 0 {
                result.push('V');
                row -= 1;
            } else {
                let mut count = Self::combination(row + col - 1, row - 1);
                if k > count {
                    result.push('H');
                    col -= 1;
                    k -= count;
                } else {
                    result.push('V');
                    row -= 1;
                }
            }
        }
        result
    }
    fn combination(n: i32, k: i32) -> usize {
        let mut result = 1;
        for i in 1..=k {
            result = result * (n + 1 - i) / i;
        }
        result as usize
    }
}