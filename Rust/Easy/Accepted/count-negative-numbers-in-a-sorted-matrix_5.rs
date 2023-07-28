impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for row in grid {
            for item in row {
                if item < 0 {
                    count += 1;
                }
            }
        }
        count
    }
}