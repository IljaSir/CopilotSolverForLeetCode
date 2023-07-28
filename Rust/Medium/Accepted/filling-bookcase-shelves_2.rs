impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        
        let mut dp = vec![0; books.len() + 1];
        for i in 1..=books.len() {
            let mut w = books[i - 1][0];
            let mut h = books[i - 1][1];
            dp[i] = dp[i - 1] + h;
            let mut j = i - 1;
            while j > 0 && w + books[j - 1][0] <= shelf_width {
                j -= 1;
                w += books[j][0];
                h = h.max(books[j][1]);
                dp[i] = dp[i].min(dp[j] + h);
            }
        }
        dp[books.len()]
    }
}