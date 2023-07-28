impl Solution {
    pub fn interval_intersection(first_list: Vec<Vec<i32>>, second_list: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![];
        let (mut i, mut j) = (0, 0);
        while i < first_list.len() && j < second_list.len() {
            let (a, b) = (first_list[i][0], first_list[i][1]);
            let (c, d) = (second_list[j][0], second_list[j][1]);
            if a <= c && c <= b {
                result.push(vec![c, b.min(d)]);
            }
            if c <= a && a <= d {
                result.push(vec![a, d.min(b)]);
            }
            if b < d {
                i += 1;
            } else {
                j += 1;
            }
        }
        result
    }
}