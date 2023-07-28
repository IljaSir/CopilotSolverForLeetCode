impl Solution {
    pub fn accounts_merge(accounts: Vec<Vec<String>>) -> Vec<Vec<String>> {
        

        let mut parents: Vec<usize> = vec![0; accounts.len()];
        let mut emails: HashMap<String, usize> = HashMap::new();
        for i in 0..accounts.len() {
            parents[i] = i;
        }
        for i in 0..accounts.len() {
            for j in 1..accounts[i].len() {
                if emails.contains_key(&accounts[i][j]) {
                    let root = Self::find_root(&parents, emails[&accounts[i][j]]);
                    parents[i] = root;
                } else {
                    emails.insert(accounts[i][j].clone(), i);
                }
            }
        }
        let mut res: HashMap<usize, HashSet<String>> = HashMap::new();
        for i in 0..accounts.len() {
            let root = Self::find_root(&parents, i);
            if !res.contains_key(&root) {
                res.insert(root, HashSet::new());
            }
            for j in 1..accounts[i].len() {
                res.get_mut(&root).unwrap().insert(accounts[i][j].clone());
            }
        }
        let mut ans: Vec<Vec<String>> = vec![];
        for (key, value) in res {
            let mut emails: Vec<String> = value.into_iter().collect();
            emails.sort();
            let mut name: Vec<String> = vec![accounts[key][0].clone()];
            name.append(&mut emails);
            ans.push(name);
        }
        ans
    }
    fn find_root(parents: &Vec<usize>, i: usize) -> usize {
        if parents[i] == i {
            return i;
        }
        parents[i] = Self::find_root(parents, parents[i]);
        parents[i]
    }
}