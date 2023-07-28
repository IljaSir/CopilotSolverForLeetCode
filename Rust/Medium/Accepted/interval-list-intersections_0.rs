impl Solution {
    pub fn interval_intersection(first_list: Vec<Vec<i32>>, second_list: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut i = 0;
        let mut j = 0;
        let mut res = vec![];
        while i < first_list.len() && j < second_list.len() {
            let a = first_list[i][0];
            let b = first_list[i][1];
            let c = second_list[j][0];
            let d = second_list[j][1];
            if a <= d && b >= c {
                res.push(vec![a.max(c), b.min(d)]);
            }
            if b < d {
                i += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}