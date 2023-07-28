impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut idxs = Vec::new();
        let mut fcs = favorite_companies;
        fcs.sort_by(|a, b| a.len().cmp(&b.len()));
        for i in 0..fcs.len() {
            let mut j = 0;
            for j in 0..fcs.len() {
                if i == j { continue; }
                if fcs[i].iter().all(|f| fcs[j].contains(f)) {
                    break;
                }
            }
            if j == fcs.len() - 1 { idxs.push(i as i32); }
        }
        idxs
    }
}