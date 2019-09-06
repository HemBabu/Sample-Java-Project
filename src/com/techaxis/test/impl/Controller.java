package com.techaxis.test.impl;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.security.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

import com.techaxis.java.test.Member;
import com.techaxis.java.test.MemberExporter;
import com.techaxis.java.test.MemberFileConverter;
import com.techaxis.java.test.MemberImporter;

import sun.security.jgss.spi.GSSContextSpi;
import sun.security.jgss.spi.GSSCredentialSpi;
import sun.security.jgss.spi.GSSNameSpi;
import sun.security.jgss.spi.MechanismFactory;

public class Controller extends MemberFileConverter {
	static String url = "F:\\Practice_Test1\\Members.txt";
	static String outFilePath = "F:\\Practice_Test1\\DataPath";
	static String outPutFleName = "_outPutFile.csv";

	public static void main(String[] args) throws Exception {

		Controller c = new Controller();
		File f = new File(url);
		c.convert(f, outFilePath, outPutFleName);

	}

	@Override
	protected MemberExporter getMemberExporter() {
		// TODO Auto-generated method stub
		MemberExporterImpl mei = new MemberExporterImpl();

		return mei;
	}

	@Override
	protected MemberImporter getMemberImporter() {
		// TODO Auto-generated method stub
		MemberImporter listMember = new MemberImporterImpl();
		return listMember;
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
		Set <Member> m=new HashSet<Member>();
		Set<String>li=new HashSet<String>();
		
		
		for(Member mi:membersFromFile) {
			li.add(mi.getId());
		}
		
		
		List <Member> noRepeat=new ArrayList<Member>();
		noRepeat.addAll(m);
		//System.out.println(li.size());
		for(String s:li) {
			for(Member mm:membersFromFile) {
				if(s.equals(mm.getId())) {
					noRepeat.add(mm);
					break;
				}
			}
		}
	System.out.println(noRepeat.size());
		return noRepeat;
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
		// TODO Auto-generated method stub

		Set<String> sName = new HashSet<String>();
		Map<String, List<Member>> memberList = new HashMap<>();

		List<Member> copyList = new ArrayList<Member>();
		copyList.addAll(validMembers);
		for (Member m1 : validMembers) {
			sName.add(m1.getState());
		}
		for (String s : sName) {
			List<Member> sameState = new ArrayList<Member>();
			for (Member m1 : validMembers) {
				if (m1.getState().equals(s)) {
					sameState.add(m1);
				}
			}
			memberList.put(s, sameState);
		}
		return memberList;
	}
}
