impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        
        let n = books.len();
        let mut dp = vec![0; n + 1];
        for i in (0..n).rev() {
            let mut width = 0;
            let mut height = 0;
            dp[i] = i32::MAX;
            for j in i..n {
                width += books[j][0];
                if width > shelf_width {
                    break;
                }
                height = height.max(books[j][1]);
                dp[i] = dp[i].min(dp[j + 1] + height);
            }
        }
        dp[0]
    }
}