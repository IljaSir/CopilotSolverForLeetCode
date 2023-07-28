impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut matrix = matrix;
        let mut res = vec![];
        while matrix.len() > 0 {
            let mut r = matrix.remove(0);
            res.append(&mut r);
            for row in matrix.iter_mut() {
                if let Some(i) = row.pop() {
                    res.push(i);
                }
            }
            matrix.reverse();
        }
        res
    }
}