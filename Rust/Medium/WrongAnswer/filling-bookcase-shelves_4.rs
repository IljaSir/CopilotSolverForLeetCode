impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        
        let mut dp = vec![0; books.len()];
        for i in 0..books.len() {
            let mut width = books[i][0];
            let mut height = books[i][1];
            dp[i] = dp[i.saturating_sub(1)] + height;
            for j in (0..i).rev() {
                width += books[j][0];
                if width > shelf_width {
                    break;
                }
                height = height.max(books[j][1]);
                dp[i] = dp[i].min(dp[j.saturating_sub(1)] + height);
            }
        }
        dp[books.len() - 1]
    }
}