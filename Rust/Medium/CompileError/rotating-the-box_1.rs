impl Solution {
    pub fn rotate_the_box(box: Vec<Vec<char>>) -> Vec<Vec<char>> {
        
        let m = box.len();
        let n = box[0].len();
        let mut res = vec![vec!['.'; m]; n];
        for i in 0..m {
            let mut j = n - 1;
            let mut k = n - 1;
            while j != 0 {
                if box[i][j] == '#' {
                    res[k][m - 1 - i] = '#';
                    k -= 1;
                } else if box[i][j] == '*' {
                    k = j - 1;
                }
                j -= 1;
            }
            if box[i][0] == '#' {
                res[k][m - 1 - i] = '#';
            }
        }
        res
    }
}