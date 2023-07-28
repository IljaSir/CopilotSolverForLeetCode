impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        
        let n = books.len();
        let mut dp = vec![0; n + 1];
        for i in 0..n {
            let mut j = i;
            let mut max_height = 0;
            let mut width = shelf_width;
            while j < n && width >= books[j][0] {
                max_height = max_height.max(books[j][1]);
                width -= books[j][0];
                dp[i + 1] = dp[i + 1].min(dp[j] + max_height);
                j += 1;
            }
        }
        dp[n]
    }
}