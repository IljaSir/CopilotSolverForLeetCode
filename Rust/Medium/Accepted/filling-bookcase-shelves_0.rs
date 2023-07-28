impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        
        let mut dp = vec![0; books.len() + 1];
        for i in 0..books.len() {
            let mut width = books[i][0];
            let mut height = books[i][1];
            dp[i + 1] = dp[i] + height;
            let mut j = i;
            while j > 0 && width + books[j - 1][0] <= shelf_width {
                j -= 1;
                width += books[j][0];
                height = height.max(books[j][1]);
                dp[i + 1] = dp[i + 1].min(dp[j] + height);
            }
        }
        dp[books.len()]
    }
}