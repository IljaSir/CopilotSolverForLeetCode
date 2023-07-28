impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut queens = vec![0; n as usize];
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        while i < n {
            while j < n {
                if Solution::is_valid(&queens, i, j) {
                    queens[i as usize] = j;
                    if i == n - 1 {
                        count += 1;
                    } else {
                        i += 1;
                        j = 0;
                        continue;
                    }
                }
                j += 1;
            }
            i -= 1;
            if i < 0 {
                break;
            }
            j = queens[i as usize] + 1;
        }
        return count;
    }

    fn is_valid(queens: &Vec<i32>, row: i32, col: i32) -> bool {
        for i in 0..row {
            if queens[i as usize] == col || (row - i).abs() == (col - queens[i as usize]).abs() {
                return false;
            }
        }
        return true;
    }
}