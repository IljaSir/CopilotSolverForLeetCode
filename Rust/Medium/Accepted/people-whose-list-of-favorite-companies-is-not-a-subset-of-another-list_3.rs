impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut comp = Vec::new();
        for i in 0..favorite_companies.len() {
            let mut temp = Vec::new();
            for j in 0..favorite_companies[i].len() {
                temp.push(favorite_companies[i][j].clone());
            }
            temp.sort();
            comp.push(temp);
        }
        for i in 0..comp.len() {
            let mut flag = true;
            for j in 0..comp.len() {
                if i == j {
                    continue;
                }
                if comp[i].len() > comp[j].len() {
                    continue;
                }
                let mut k = 0;
                let mut l = 0;
                while k < comp[i].len() && l < comp[j].len() {
                    if comp[i][k] == comp[j][l] {
                        k += 1;
                        l += 1;
                    } else {
                        l += 1;
                    }
                }
                if k == comp[i].len() {
                    flag = false;
                    break;
                }
            }
            if flag {
                res.push(i as i32);
            }
        }
        res
    }
}