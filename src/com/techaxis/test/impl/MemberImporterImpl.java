package com.techaxis.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.techaxis.java.test.Member;
import com.techaxis.java.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

	List<Member> listMember =new ArrayList<Member>();

	
		/*
		 * Implement the missing logic
		 */

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line =br.readLine();
			while (line != null) {
				Member member = new Member();
				//System.out.println(line);
				member.setId(line.substring(0, 11).trim());
				member.setLastName(line.substring(12, 36).trim());
				member.setFirstName(line.substring(37, 61).trim());
				member.setAddress(line.substring(62, 91).trim());
				member.setCity(line.substring(92, 111).trim());
				member.setState(line.substring(112, 115).trim());
				member.setZip(line.substring(116, 121).trim());
				if(!listMember.contains(member)) {
					listMember.add(member);
				}
				
				line = br.readLine();
				
			}
		}
		

		return listMember;
	}

}
