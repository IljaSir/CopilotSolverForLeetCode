impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in grid {
            for j in i {
                if j < 0 {
                    count += 1;
                }
            }
        }
        count
    }
}